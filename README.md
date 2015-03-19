ebean-bug
=========
This project demonstrates a problem in Ebean library.

1. Prepare a database, run `src/main/sql/schema.sql` script.
2. Check database settings in `src/main/resources/ebean.properties`.
3. To run it, use

      $ mvn compile process-classes exec:java -Dexec.mainClass="me.fornever.ebeanbug.Application"

You'll get an exception:

```
Exception in thread "main" javax.persistence.PersistenceException: query does not contain any named bind parameters?
	at com.avaje.ebeaninternal.server.util.BindParamsParser.parseNamedParams(BindParamsParser.java:119)
	at com.avaje.ebeaninternal.server.util.BindParamsParser.parseNamedParams(BindParamsParser.java:113)
	at com.avaje.ebeaninternal.server.util.BindParamsParser.parseSql(BindParamsParser.java:99)
	at com.avaje.ebeaninternal.server.util.BindParamsParser.parse(BindParamsParser.java:47)
	at com.avaje.ebeaninternal.server.util.BindParamsParser.parse(BindParamsParser.java:43)
	at com.avaje.ebeaninternal.server.query.CQueryPredicates.buildBindWhereRawSql(CQueryPredicates.java:239)
	at com.avaje.ebeaninternal.server.query.CQueryPredicates.prepare(CQueryPredicates.java:276)
	at com.avaje.ebeaninternal.server.query.CQueryPredicates.prepare(CQueryPredicates.java:264)
	at com.avaje.ebeaninternal.server.query.CQueryBuilder.buildQuery(CQueryBuilder.java:193)
	at com.avaje.ebeaninternal.server.query.CQueryEngine.findMany(CQueryEngine.java:162)
	at com.avaje.ebeaninternal.server.query.DefaultOrmQueryEngine.findMany(DefaultOrmQueryEngine.java:80)
	at com.avaje.ebeaninternal.server.core.OrmQueryRequest.findList(OrmQueryRequest.java:284)
	at com.avaje.ebeaninternal.server.core.DefaultServer.findList(DefaultServer.java:1367)
	at com.avaje.ebeaninternal.server.querydefn.DefaultOrmQuery.findList(DefaultOrmQuery.java:933)
	at me.fornever.ebeanbug.Application.call(Application.java:25)
	at me.fornever.ebeanbug.Application.main(Application.java:12)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:483)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134)
```