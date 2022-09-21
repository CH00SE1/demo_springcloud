package com.stock.seata.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * @author CHOOSE1
 * @date 2022-09-19 10:29:22
 */
public class AutomaticGenerated {

    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.10.87:3306/seata_stock?useUnicode=true&rewriteBatchedStatements=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "11098319";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("CH00SE 1") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .dateType(DateType.ONLY_DATE)
                            // 指定输出目录
                            .outputDir(System.getProperty("user.dir") + "/seata/stock_seata/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> builder.parent("com.stock.seata"))
                .strategyConfig(builder -> {
                    builder.addInclude("stock_tb") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_", "sys_"); // 设置过滤表前缀
                })
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

}
