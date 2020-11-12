import React, { Component } from 'react'
import UserConntacts from './UserConntacts';

export default class Signup extends Component {


    constructor() {
        super();
        this.state = {
            userEmail : "",
            userIn : false
        }
        this.submitInput = this.submitInput.bind(this);
    }

    submitInput(event) {

        event.preventDefault();

        let typedEmail = document.getElementById("user_email").value;
            console.log(typedEmail);


        let userPassword = document.getElementById("user_password").value;
            console.log(userPassword);

            this.checkForDupeUsers(typedEmail, userPassword);

    }



    postUser(userEmailToPost, userPassword) {

        const data = { email: userEmailToPost, password:userPassword };

       let jsonData = JSON.stringify(data);

       console.log("Json Data is: ");
       console.log(jsonData);

fetch('http://localhost:8080/contactmanagerapi/v1/user/' , {
  method: 'POST', // or 'PUT'
  headers: {
    'Content-Type': 'application/json',
  },
  body: jsonData,
})
.then(response => response.json())
.then(data => {
  console.log('Success:', data);
  {
    
        this.setState({
            userEmail: userEmailToPost,
            userIn: true
 
          });
    
}
})
.catch((error) => {
  console.error('Error:', error);
  

});


    }

    

    checkForDupeUsers(usserEmailToCheck, userPassword) {
        const data = { email: usserEmailToCheck, password:"n/a" };

       let jsonData = JSON.stringify(data);

       console.log("Json Data is: ");
       console.log(jsonData);

fetch('http://localhost:8080/contactmanagerapi/v1/user/dupes', {
  method: 'POST', // or 'PUT'
  headers: {
    'Content-Type': 'application/json',
  },
  body: jsonData,
})
.then(response => response.json())
.then(data => {
  console.log('Success:'); 
  console.log(data);
  if(data == 1)
  {
    console.log("That user email already exists, if it is you, login instead, else use another email");
    alert("That user email already exists, if it is you login instead, else use another email");
  }
  else
  {
      console.log("data.length is zero???");
    //   if(usserEmailToCheck)
    //         {
    //             this.setState({
    //                 userEmail: usserEmailToCheck,
         
    //               });
    //         }


            this.postUser(usserEmailToCheck, userPassword);
  }
})
.catch((error) => {
  console.error('Error:', error);
  

});


    }

    render() {

        if(this.state.userIn)
        {
            return (<div>
                <UserConntacts signedInEmail = {this.state.userEmail}/>

            </div>)
        }
        else
        {
        return (
            <div>
                <h2 id= "signupLabel">Signup</h2>

                <form onSubmit={this.submitInput}>
                    <input placeholder="Enter email address" type="text" id="user_email" name="uemail" />
                    <br/> <br/>
                    <input placeholder="Enter password" type="password" id="user_password" name="upass" />
                    <br/> <br/>
                    <input  id="submitButton" type="submit" value="Submit"/>
                </form> 
            </div>
        )
        }
    }
}
