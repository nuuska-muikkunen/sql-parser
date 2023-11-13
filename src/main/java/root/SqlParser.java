package root;

import java.util.Arrays;

public class SqlParser {
    public static void main(String[] args) {
        String inputString = "SELECT author.name, count(book.id), sum(book.cost) \n"
                + "FROM author \n"
                + "LEFT JOIN book ON (author.id = book.author_id) \n"
                + "GROUP BY author.name \n"
                + "HAVING COUNT(*) > 1 AND SUM(book.cost) > 500\n"
                + "LIMIT 10;";
        SqlQuery testQuery = new SqlQuery();
        testQuery = parseSqlString(inputString);
    }
    public static SqlQuery parseSqlString(String sqlString) {
        SqlQuery parsedSql = new SqlQuery();
        int startPointForSearch = 0;
        String[] columnsToSelect = new String[10];
        if (sqlString.startsWith("SELECT")) {
            columnsToSelect = sqlString.substring(7, sqlString.indexOf("\nFROM")).split(", ");
            parsedSql.setColumns(Arrays.stream(columnsToSelect).toList());
        }
//        System.out.println(parsedSql.getColumns());
//        SqlQuery res = new SqlQuery();
        return parsedSql;
    }
}
