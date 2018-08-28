package com.lcy.swaggerdoc;

import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.OrderBy;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by liChenYu on 2018/8/28
 */
@Component
public class GenerateDoc implements CommandLineRunner {
    @Value("${api-docs.url}")
    String apiDocsUrl = "http://localhost:8080/v2/api-docs";

    @Value("${adocFile.path}")
    String aDocFilePath = "docs/asciidoc/generated/";

    @Override
    public void run(String... args) throws Exception {
        generateAsciiDocs();
    }

    public void generateAsciiDocs() throws Exception {
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withDefinitionOrdering(OrderBy.NATURAL)
                .withGeneratedExamples()
                .withPathsGroupedBy(GroupBy.TAGS)
                .withListDelimiter()
                .build();

        Swagger2MarkupConverter.from(new URL(apiDocsUrl))
                .withConfig(config)
                .build()
                .toFile(Paths.get(aDocFilePath + "index"));
    }
}
