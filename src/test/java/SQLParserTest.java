import org.junit.jupiter.api.Test;
import root.SqlParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;

public class SQLParserTest {
    static final String PATH_TO_FIXTURE = "src/test/resources/sqlrequests/";

    public static String fixture(String nameOfFile) {
        return PATH_TO_FIXTURE + nameOfFile;
    }

    @Test
    public void outputTest() throws Exception {
        var expected = Files.readString(Paths.get(fixture("selectSql"))
                .toAbsolutePath().normalize()).trim();
        var result = SqlParser.parseSqlString("SELECT author.name, count(book.id), sum(book.cost) \n"
                + "FROM author \n"
                + "LEFT JOIN book ON (author.id = book.author_id) \n"
                + "GROUP BY author.name \n"
                + "HAVING COUNT(*) > 1 AND SUM(book.cost) > 500 \n"
                + "LIMIT 10;").getColumns().toString();
        assertThat(result).isEqualTo(expected);
    }

}
