#  Quiz-App REST API Documentation
This documentation provides an overview of the endpoints available in the  Quiz System API.

## Base URL
The base URL for accessing the API is: https://quizsystem-production.up.railway.app/quizzes
### Quiz Resource

### Create a Quiz

   - URL: https://quizsystem-production.up.railway.app/quizzes
   - Method: POST
   - Description: Create a new quiz.
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
   - Description: Get a list of active quizzes (quizzes that are currently within their start and end time).
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
   - Description: Get the result of a quiz by its ID.
   - Path Variable:

   - {id}: ID of the quiz
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
   - Description: Get a list of all quizzes.

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
        
