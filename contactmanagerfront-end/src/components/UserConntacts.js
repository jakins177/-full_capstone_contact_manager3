import React, { Component } from 'react'
import ContactList from './ContactList'



export default class UserConntacts extends Component {


  constructor() {
    super();
    this.state = {
        showAddContact : false
    }

    this.postContact = this.postContact.bind(this);
    this.submitNewContact = this.submitNewContact.bind(this);

  }

    addContactClicked()
    {
      this.setState({
        showAddContact: !this.state.showAddContact

      });
      

    }


    submitNewContact(event) {
    

      event.preventDefault();


      let typedName = document.getElementById("new_contact_name").value;
            console.log(typedName);


      let typedEmail = document.getElementById("new_contact_email").value;
            console.log(typedEmail);


      this.postContact(typedName, typedEmail);

    }

    postContact(typedName, typedEmail) {

        const data = { owner_user_name: this.props.signedInEmail, contact_name: typedName, contact_email: typedEmail };

       let jsonData = JSON.stringify(data);

       console.log("Json Data is: ");
       console.log(jsonData);

fetch('http://localhost:8080/contactmanagerapi/v1/contact/' , {
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
        //     userEmail: userEmailToPost,
        //     userIn: true
        showAddContact : false
 
           });
    
}
})
.catch((error) => {
  console.error('Error:', error);
  

});


    }

    render() {

      if(this.state.showAddContact) {

        return(
          <div>
            <h2>welcome!</h2>

                <button onClick={() => this.addContactClicked()}> AddContact </button>
                <br/><br/>


                <form onSubmit={this.submitNewContact}>
                    <input placeholder="Enter Name Of New Contact" type="text" id="new_contact_name" name="uname" />
                    <br/> <br/>
                    <input placeholder="Enter Email Address Of New Contact" type="text" id="new_contact_email" name="uname" />
                    <br/> <br/>
                    <input  id="submitButton" type="submit" value="Submit"/>
                </form> 
                <br/><br/>
                
                <ContactList ownerUser =  {this.props.signedInEmail}/>

          </div>
        )
      }
        return (
            <div>
                <h2>welcome!</h2>
                <button onClick={() => this.addContactClicked()}> AddContact </button>
                <br/><br/>
                <ContactList ownerUser =  {this.props.signedInEmail} />
            </div>
        )
    }
}
