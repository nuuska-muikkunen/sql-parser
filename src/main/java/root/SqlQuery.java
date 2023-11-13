package root;

import java.util.List;
import root.keywords.Source;
import root.keywords.Join;
import root.keywords.WhereClause;
import root.keywords.Sort;

public class SqlQuery {
    private List<String> columns;
    private List<Source> fromSources;
    private List<Join> joins;
    private List<WhereClause> whereClauses;
    private List<String> groupByColumns;
    private List<Sort> sortColumns;
    private Integer limit;
    private Integer offset;

}
