package me.fornever.ebeanbug;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import me.fornever.ebeanbug.entities.MyTable;

public class Application {
	public static void main(String[] args) {
		System.out.println(call());
		System.out.println(call());
	}

	private static int call() {
		String sql = "select * from my_table where id = :id and name = :name";
		RawSql rawSql = RawSqlBuilder.unparsed(sql)
				.columnMapping("id", "id")
				.columnMapping("name", "name")
				.create();
		Query<MyTable> query = Ebean.find(MyTable.class);
		query.setParameter("id", "1");
		query.setParameter("name", "name");
		query.setRawSql(rawSql);
		return query.findList().size();
	}
}