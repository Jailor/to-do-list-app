# Guess the Number Game

## About :thought_balloon:
The task was to implement the "Higher or Lower" number guessing game, as given by the specification from
[Tim Buchalka's Masterclass](https://www.udemy.com/course/java-spring-framework-masterclass/) from Udemy.

## Features :white_check_mark:
The game has the following features:
 - Allows the user to play the game in the browser
 - User cannot input invalid numbers
 - Internationalization support for the Spanish language
 - Homepage and possibility to replay the game after it has been completed

## Implementation and GUI :computer:

### Notable implementation details
- Spring Boot has been used for building the projects, and many framework features have been explored during this project like constructor dependency injection, beans, contexts, request interception, annotations and many more.
- Lombok allows for less boilerplate code with its annotations.
- Constants are stored in property files for easy access and less code duplication
- Internationalization support for english and spanish using spring functionality
- Multi-module project, increases cohesion
- Thymeleaf template engine used frontend logic. 

Because there is no CSS, images will look a bit dated, but they still show the basic functionality.
### Start
<img src="/ss/start.PNG" width="900" >

### Response
<img src="/ss/response.PNG" width="900" >

### Spanish
<img src="/ss/spanish_i18n.PNG" width="900" >

### End
<img src="/ss/end.PNG" width="900" >
