# Rest APIs exposed as part of the sample project:

: GET API - Get All Snippets - http://localhost:8080/snippets
: GET API - Get Snippet from Id - http://localhost:8080/snippet/24606899-54aa-4443-8abb-339fbf1cad04
: GET API - Get Snippet by Title - http://localhost:8080/snippet/title/HTML: Hello World
: GET API - Get Snippets by Created - http://localhost:8080/snippet/created?start=2016-07-30&end=2018-01-28

: POST - Save Snippet - http://localhost:8080/snippet | Body - {
                                                                	"title":"Snippet Title - Hello World",
                                                                	"code": "console.log('Snippet Title - Hello World')"
                                                                }
: POST - Save multiple Snippets - http://localhost:8080/snippets | Body - [{
                                                                          	"title":"Snippet Title - Hello World - 1",
                                                                          	"code": "console.log('Snippet Title - Hello World - 1')"
                                                                          },{
                                                                          	"title":"Snippet Title - Hello World - 2",
                                                                          	"code": "console.log('Snippet Title - Hello World - 2')"
                                                                          },{
                                                                          	"title":"Snippet Title - Hello World - 3",
                                                                          	"code": "console.log('Snippet Title - Hello World - 3')"
                                                                          },{
                                                                          	"title":"Snippet Title - Hello World - 4",
                                                                          	"code": "console.log('Snippet Title - Hello World - 4')"
                                                                          }]

: PUT - Update Snippet - http://localhost:8080/snippet | Body - {
                                                                 	"id":"65c4cf65-9771-4d84-82f0-8ceeb339c2e6",
                                                                 	"title":"Snippet Title - Hello World - PUT Call",
                                                                 	"code": "console.log('Snippet Title - Hello World')"
                                                                 }


: Actuator URLs (All GET URLs, except for shutdown):
: http://localhost:8080/configprops
: http://localhost:8080/springbeans
: http://localhost:8080/info
: http://localhost:8080/health
: http://localhost:8080/trace
: http://localhost:8080/metrics
: http://localhost:8080/mappings
: http://localhost:8080/autoconfig
: http://localhost:8080/heapdump
: http://localhost:8080/dump.json | http://localhost:8080/dump
: http://localhost:8080/env
: http://localhost:8080/shutdown (POST Method)
: Custom METRICS - http://localhost:8080/metrics/counter.services.greeting.invoked

Quick Reads:
: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods