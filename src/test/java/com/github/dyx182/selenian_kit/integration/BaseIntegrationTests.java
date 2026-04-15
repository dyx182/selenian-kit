package com.github.dyx182.selenian_kit.integration;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public abstract class BaseIntegrationTests {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        //gui
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "target/screenshots";
    }
}
