import React, { Component } from 'react'

export default class ContactList extends Component {
   
  constructor() {
    super();
    this.state = {
      contactData : []
    }
  }
   
   componentDidMount()
   {
    fetch('http://localhost:8080/contactmanagerapi/v1/contact/' + this.props.ownerUser)
    .then((response) => {
      return response.json();
    })
    .then((data) => {
       console.log(data);

       this.setState({
        contactData: data
      })
      
    }) 
   }
   
    render() {
        return (
            <div>

      {
        this.state.contactData.map(contact => {
          return <div className = "json" > 
            <h3> {contact.contact_name} </h3> 
          
            <h3>
              {contact.contact_email} </h3> 
            
              <br/>
              </div>
              
        })
      } 

                
            </div>
        )
    }
}
