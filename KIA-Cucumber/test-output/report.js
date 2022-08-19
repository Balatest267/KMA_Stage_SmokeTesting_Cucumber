$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/java/feature/ProdSmokeTesting.feature");
formatter.feature({
  "line": 1,
  "name": "Login Action",
  "description": "",
  "id": "login-action",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 4,
      "value": "#With Examples keyword"
    }
  ],
  "line": 5,
  "name": "Successful Login with valid credentials",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "user is on KIA web portal Landing Page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "page title is Kia Owners Portal",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user clicks the Sign in button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user enter the \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user clicks the login button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user is on welcome page",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user pick the vehicle",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user is on dashboard page",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "fetch the name of the vehicle",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 18,
      "value": "#Then get the status of the door"
    },
    {
      "line": 19,
      "value": "#Then user clicks the lockUnlock option"
    },
    {
      "line": 21,
      "value": "#Then user clicks the remoteClimate option"
    },
    {
      "line": 23,
      "value": "#Given user is on Remote Section"
    },
    {
      "line": 24,
      "value": "#When user perform Remote Door features"
    },
    {
      "line": 25,
      "value": "#And user perform Remote Climate  features"
    },
    {
      "line": 26,
      "value": "#Then status of the Remote Door and Climate status"
    },
    {
      "line": 28,
      "value": "#Given user is on Schedules Section"
    },
    {
      "line": 29,
      "value": "#Given user is on Locations Section"
    },
    {
      "line": 30,
      "value": "#Given user is on Maintenance Section"
    },
    {
      "line": 31,
      "value": "#Given user is on MyCarZone Section"
    },
    {
      "line": 33,
      "value": "#Then user find the vehicle location"
    },
    {
      "line": 34,
      "value": "#Then capture the alert message"
    }
  ],
  "line": 35,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 38,
  "name": "",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 40,
      "id": "login-action;successful-login-with-valid-credentials;;1"
    },
    {
      "cells": [
        "testen15@mailinator.com",
        "Password1"
      ],
      "line": 41,
      "id": "login-action;successful-login-with-valid-credentials;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 41,
  "name": "Successful Login with valid credentials",
  "description": "",
  "id": "login-action;successful-login-with-valid-credentials;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "user is on KIA web portal Landing Page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "page title is Kia Owners Portal",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user clicks the Sign in button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user enter the \"testen15@mailinator.com\" and \"Password1\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user clicks the login button",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user is on welcome page",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user pick the vehicle",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user is on dashboard page",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "fetch the name of the vehicle",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 18,
      "value": "#Then get the status of the door"
    },
    {
      "line": 19,
      "value": "#Then user clicks the lockUnlock option"
    },
    {
      "line": 21,
      "value": "#Then user clicks the remoteClimate option"
    },
    {
      "line": 23,
      "value": "#Given user is on Remote Section"
    },
    {
      "line": 24,
      "value": "#When user perform Remote Door features"
    },
    {
      "line": 25,
      "value": "#And user perform Remote Climate  features"
    },
    {
      "line": 26,
      "value": "#Then status of the Remote Door and Climate status"
    },
    {
      "line": 28,
      "value": "#Given user is on Schedules Section"
    },
    {
      "line": 29,
      "value": "#Given user is on Locations Section"
    },
    {
      "line": 30,
      "value": "#Given user is on Maintenance Section"
    },
    {
      "line": 31,
      "value": "#Given user is on MyCarZone Section"
    },
    {
      "line": 33,
      "value": "#Then user find the vehicle location"
    },
    {
      "line": 34,
      "value": "#Then capture the alert message"
    }
  ],
  "line": 35,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "ProdSmokeTestingSD.user_is_on_KIA_web_portal_Landing_Page()"
});
formatter.result({
  "duration": 134015133200,
  "status": "passed"
});
formatter.match({
  "location": "ProdSmokeTestingSD.page_title_is_Kia_Owners_Portal()"
});
formatter.result({
  "duration": 23953800,
  "status": "passed"
});
formatter.match({
  "location": "ProdSmokeTestingSD.user_clicks_the_Sign_in_button()"
});
formatter.result({
  "duration": 10190195500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testen15@mailinator.com",
      "offset": 16
    },
    {
      "val": "Password1",
      "offset": 46
    }
  ],
  "location": "ProdSmokeTestingSD.user_enter_the_username_and_password(String,String)"
});
formatter.result({
  "duration": 290763200,
  "status": "passed"
});
formatter.match({
  "location": "ProdSmokeTestingSD.user_clicks_the_login_button()"
});
formatter.result({
  "duration": 30066032900,
  "status": "passed"
});
formatter.match({
  "location": "ProdSmokeTestingSD.user_is_on_welcome_page()"
});
formatter.result({
  "duration": 85680908400,
  "status": "passed"
});
formatter.match({
  "location": "ProdSmokeTestingSD.user_pick_the_vehicle()"
});
formatter.result({
  "duration": 145645946100,
  "status": "passed"
});
formatter.match({
  "location": "ProdSmokeTestingSD.user_is_on_dashboard_page()"
});
formatter.result({
  "duration": 20019707200,
  "status": "passed"
});
formatter.match({
  "location": "ProdSmokeTestingSD.fetch_the_name_of_the_vehicle()"
});
formatter.result({
  "duration": 10075409400,
  "status": "passed"
});
formatter.match({
  "location": "ProdSmokeTestingSD.close_the_browser()"
});
formatter.result({
  "duration": 2658776700,
  "status": "passed"
});
});