# Currency-Exchange
Currency-service 
oShould expose un-authenticated APIs to ▪Add user with Roles.
Only two roles allowed –ADMINand GENERAL
▪Provide JWT for a user when username and password are provided
oShould expose Controllers with feign clients for all currency-exchange-serviceand currency-conversion-service
APIsoShould authenticate and authorizerequests before propagating them forward.
o*Additional points will be provided if the password is encoded before persisting to the database using a standard encryption technique such as SHA-256.

•Currency-exchange
oShould expose REST APIs to
▪Get all available exchange rates through an authenticated request
▪Get one exchange rate through an authenticated request
▪Add an exchange rate as an ADMIN
▪Update an exchange rate as an ADMIN
▪Delete an exchange rate as an ADMIN
▪Import and update exchange rates through a .csv file as an ADMIN
oDefine a batch job for the import functionality
oCache responses for get-all-exchange-rates and get-one-exchange-rate APIs. 
(For now an in-memory cache can be used but the possibilities of other external caches such as Redis must also be explored)

•Currency-conversion
oShould expose a REST API to convert an amount from one currency type to another through an authenticated request.
oThe API should internally call currency-exchange-serviceto get the exchange rates.

•Swagger
oEach of the above services should have swagger documentation of all APIs

•Zipkin
oEach of the above services should be registered to a Zipkin server to trace logs and request calls in a centralized manner
