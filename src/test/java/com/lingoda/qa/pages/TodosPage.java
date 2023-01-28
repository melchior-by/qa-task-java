package com.lingoda.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TodosPage {
    public final static String URL = "https://todomvc.com/examples/polymer/index.html";

    public SelenideElement todoInput = $("#new-todo");

    public ElementsCollection todoList = $$("ul.td-todos>li");

    public SelenideElement getTodoInputElement(int number) {
        return $(String.format("ul.td-todos>li:nth-child(%d)", number));
    }
}
