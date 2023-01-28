# qa-task-java

## Task
Write a basic browser automation framework to validate a Polymer website. The focus should be on the interaction with the browser.
The Web Application under test http://todomvc.com/
1. The first step should be to load the website, click within the JavaScript tab, and select the Polymer link.
2. The second step should be: Add two Todo items
3. Bonus: (optional stretch goal): Edit the content of the second Todo item

## Guide
1. Make sure Java 19, Maven and Allure Report being installed
2. Test can be run by `mvn clean test` command in console
3. To generate report, come to the target directory by `cd target` and use `allure serve` command to show test report
