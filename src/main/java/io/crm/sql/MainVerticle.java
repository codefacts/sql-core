package io.crm.sql;

import io.crm.sql.service.CRUDService;
import io.crm.sql.service.FileUploaderService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.ext.jdbc.JDBCClient;

final public class MainVerticle extends AbstractVerticle {
    private JDBCClient jdbcClient;

    @Override
    public void start() throws Exception {
        initialize();
        registerCodecs();
        registerEvents();


        System.out.println("<----------------------------------SQL-CORE------------------------------------->");
    }

    private void initialize() {

        jdbcClient = JDBCClient.createShared(vertx, MyApp.dbConfig());
    }

    @Override
    public void stop() throws Exception {
        if (jdbcClient != null) jdbcClient.close();
    }

    private void registerEvents() {

        FileUploaderService fileUploaderService = new FileUploaderService(vertx);
        vertx.eventBus().consumer(MyEvents.SAVE_BYTEARRAY, fileUploaderService::saveByteArray);

        CRUDService crudService = new CRUDService(vertx, jdbcClient);
        vertx.eventBus().consumer(MyEvents.SQL_INSERT, crudService::insert);
        vertx.eventBus().consumer(MyEvents.SQL_UPDATE, crudService::update);
        vertx.eventBus().consumer(MyEvents.SQL_DELETE, crudService::delete);
        vertx.eventBus().consumer(MyEvents.SQL_QUERY, crudService::query);
    }

    private void registerCodecs() {
    }
}
