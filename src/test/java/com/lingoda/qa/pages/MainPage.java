package com.lingoda.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public final static String URL = "https://todomvc.com/";

    public SelenideElement javaScriptTab = $x("//*[@id='tabsContent']//*[contains(text(),'JavaScript')]");

    public SelenideElement polymerLink = $x("//a[contains(text(), 'Polymer')]");

}
