package com.lingoda.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.lingoda.qa.pages.MainPage;
import com.lingoda.qa.pages.TodosPage;
import com.lingoda.qa.service.MainService;
import com.lingoda.qa.service.TodosService;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.testng.Assert.assertEquals;

public class MainPageTest {

    MainService mainService = new MainService();
    TodosService todosService = new TodosService();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeTest
    public void setUp() {
        open(MainPage.URL);
    }
    @Test
    public void testPolymerTodoItemsInteraction() {
        String firstElement = "a";
        String secondElement = "b";
        String newValue = "c";
        goToPolymerTodo();
        addTwoTodoItems(firstElement, secondElement);
        editContentOfTheSecondTodoItem(firstElement, newValue);
    }

    @Step("Click within the JavaScript tab, and select the Polymer link")
    public void goToPolymerTodo() {
        mainService.goToPolymerTodo();
        webdriver().shouldHave(url(TodosPage.URL));
    }

    @Step("Add two Todo items")
    public void addTwoTodoItems(String firstElement, String secondElement) {
        todosService.addTodoElement(firstElement);
        todosService.addTodoElement(secondElement);
        List<String> todoList = todosService.getTodosElements();
        assertEquals(todoList, Arrays.asList(firstElement, secondElement));
    }

    @Step("Edit the content of the second Todo item")
    public void editContentOfTheSecondTodoItem(String firstElement, String newValue) {
        todosService.editTodoElement(2, newValue);
        List<String> todoList = todosService.getTodosElements();
        assertEquals(todoList, Arrays.asList(firstElement, newValue));
    }
}
