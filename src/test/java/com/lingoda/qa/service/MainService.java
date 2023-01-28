package com.lingoda.qa.service;

import com.lingoda.qa.pages.MainPage;

public class MainService {

    private MainPage page;

    public MainService() {
        page = new MainPage();
    }

    public void goToPolymerTodo() {
        page.javaScriptTab.click();
        page.polymerLink.click();
    }
}
