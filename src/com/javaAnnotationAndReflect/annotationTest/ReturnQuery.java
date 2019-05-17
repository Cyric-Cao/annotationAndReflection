package com.javaAnnotationAndReflect.annotationTest;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 返回查询 sql 语句方法
 */
public class ReturnQuery {
    public static String query(Object u) {
        StringBuilder sb = new StringBuilder();
        //获得 Class 对象
        Class uClazz = u.getClass();
        //判断是否是 Table 类型的注解
        boolean isTableAnnotation = uClazz.isAnnotationPresent(Table.class);
        if (!isTableAnnotation) {
            return null;
        }
        //获取 table 名字
        Table tableAnnotation = (Table) uClazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.value();

        //加入 where 1=1 ，是为了防止未来如果没有条件的情况下也不会报错
        sb.append("select * from ").append(tableName).append(" where 1=1 ");

        //获取类属性的所有字段
        Field[] fArray = uClazz.getDeclaredFields();

        //遍历所有字段
        for (Field field : fArray) {
            //判断是否是 Column 类型的注解
            boolean isColumn = field.isAnnotationPresent(Column.class);
            if (!isColumn) {
                continue;
            }

            //获取字段上面注解的值，即Column注解的值
            Column columnAnnotation = field.getAnnotation(Column.class);
            String columnName = columnAnnotation.value();

            //获取方法名称
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

            //获取字段值
            Object fieldValue = null;
            try {
                Method getMethod = uClazz.getMethod(getMethodName);
                fieldValue = getMethod.invoke(u);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //拼接 Sql
            if (fieldValue == null || (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
                continue;
            }

            sb.append(" and ").append(columnName);
            if (fieldValue instanceof String) {
                if (((String) fieldValue).contains(",")) {
                    String[] values = ((String) fieldValue).split(",");
                    sb.append(" in (");
                    for (String value : values) {
                        sb.append("'").append(value).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(")");
                } else {
                    sb.append("=").append(" '").append(fieldValue).append(" '");
                }
            } else if (fieldValue instanceof Integer) {
                sb.append("= ").append(fieldValue);
            }
        }
        return sb.toString();
    }
}
