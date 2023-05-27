#  Quiz-App EndPoint Documentation
This documentation provides an overview of the endpoints available in the Quiz-App.

## Base URL
The base URL for accessing the Endpoint is: https://quizsystem-production.up.railway.app/quizzes

### Quiz-App All Endpoints

### Create a new Quiz

   - URL: https://quizsystem-production.up.railway.app/quizzes
   - Method: POST
   - Description: User can create a new quiz in the database.
   - Request Body:
   
    {
      "description": "Example question 4",
      "options": [
          "Ans1",
          "Ans2",
          "Ans3",
          "Ans4"
      ],
      "answer": 2,
      "startDate": "2023-05-27T22:17:00",
      "endDate": "2023-05-27T22:19:00"
    }

       Response Body:


    {
      "qid": 4,
      "description": "Example question 4",
      "options": [
          "Ans1",
          "Ans2",
          "Ans3",
          "Ans4"
      ],
      "answer": 2,
      "startDate": "2023-05-27T22:17:00",
      "endDate": "2023-05-27T22:19:00",
      "status": "INACTIVE"
  }
    
    
    
 ###  Get Active Quizzes
 
   - URL: https://quizsystem-production.up.railway.app/quizzes/active
   - Method: GET
   - Description: User can get a list of active quizzes, active quizzes are (those quizzes that currently lie in between startDate and endDate of the quiz).
   
   - Response Body:


    [
        {
            "qid": 3,
            "description": "Example question 3",
            "options": [
                "Ans1",
                "Ans2",
                "Ans3",
                "Ans4"
            ],
            "answer": 2,
            "startDate": "2023-05-27T22:16:00",
            "endDate": "2023-05-27T22:18:00",
            "status": "ACTIVE"
        },
        {
            "qid": 4,
            "description": "Example question 4",
            "options": [
                "Ans1",
                "Ans2",
                "Ans3",
                "Ans4"
            ],
            "answer": 2,
            "startDate": "2023-05-27T22:17:00",
            "endDate": "2023-05-27T22:19:00",
            "status": "ACTIVE"
        }
    ]
    
    
   ### Get Quiz Result
   
   -  URL: https://quizsystem-production.up.railway.app/quizzes/{id}/result
   -  Method: GET
   - Description: User can get the result of particular quiz by their quiz id.
   - Path Variable: {id}: ID of the quiz
   
   - Response Body:

    {
        "question": "Example question 3",
        "options": [
            "Ans1",
            "Ans2",
            "Ans3",
            "Ans4"
        ],
        "answer": 2
    
    
    
### Get All Quizzes

   - URL: https://quizsystem-production.up.railway.app/quizzes/all
   - Method: GET
   - Description: User can get a list of All quizzes wheather quiz has ACTIVE, INACTIVE or FINISHED status.

   - Response Body:
    
    [
        {
            "qid": 1,
            "description": "Example question 1",
            "options": [
                "Ans1",
                "Ans2",
                "Ans3",
                "Ans4"
            ],
            "answer": 2,
            "startDate": "2023-05-27T22:14:00",
            "endDate": "2023-05-27T22:16:00",
            "status": "FINISHED"
        },
        {
            "qid": 2,
            "description": "Example question 2",
            "options": [
                "Ans1",
                "Ans2",
                "Ans3",
                "Ans4"
            ],
            "answer": 2,
            "startDate": "2023-05-27T22:15:00",
            "endDate": "2023-05-27T22:17:00",
            "status": "FINISHED"
        }  
    ]
        
