# Visual Nuts Exercise - Pedro Ventura

### Reference Documentation
For the test case, I've created an API, using SpringBoot framework and Junit + Mockito for the Unit tests

### Exercise 1
- Write or describe an algorithm that prints the whole integer numbers to the console, start
from the number 1, and print all numbers going up to the number 100.
However, when the number is divisible by 3, do not print the number, but print the word
'Visual'. If the number is divisible by 5, do not print the number, but print 'Nuts'. And for all
numbers divisible by both (eg: the number 15) the same, but print 'Visual Nuts'

- API endpoint: http://localhost:8080/nuts/v1/numbers

### Exercise 2
returns the number of countries in the world:
- API endpoint: http://localhost:8080/nuts/v1/numbers/numberOfCountriesInTheWorld

finds the country with the most official languages, where they officially speak German (de):
- API endpoint: http://localhost:8080/nuts/v1/countryWithMostImportantLanguageGerman

that counts all the official languages spoken in the listed countries:
- API endpoint: http://localhost:8080/nuts/v1/countOfSpokenLanguagesOnListedCountries

to find the country with the highest number of official languages:
- API endpoint: http://localhost:8080/nuts/v1/countriesWithHighestNumberOfSpokenLanguages

to find the most common official language(s), of all countries:
- API endpoint: http://localhost:8080/nuts/v1/mostCommonOfficialLanguageOfAllCountries

### Guides
* The Unit test was developed only for the class PrintNumbersService, considering the lack of time to work on this project
* Postman collections to facilitate the access to the API, are on folder postman, at the root

### Data used for test
The Data used for the test cases, are on the class GenerateData.
