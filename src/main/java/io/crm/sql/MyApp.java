package io.crm.sql;

import io.crm.util.Util;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by someone on 12/11/2015.
 */
public class MyApp {
    public static final int MIN_PAGE_SIZE = 5;
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;
    private static final JsonObject config = loadConfig();

    static {
        if (loadConfig().getBoolean("dev-mode")) {
            System.setProperty("dev-mode", "true");
        }
    }

    public static final JsonObject dbConfig() {
        return loadConfig().getJsonObject("database");
    }

    public static void main(String... args) {
        Vertx.vertx().deployVerticle(new MainVerticle());
    }

    public static JsonObject loadConfig() {
        if (config == null) {
            return Util.loadConfig(MyApp.class);
        } else return config;
    }
}
