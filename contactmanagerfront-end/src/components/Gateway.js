import React, { Component } from 'react'
import Login from './Login'
import Signup from './Signup'

export default class Gateway extends Component {
    

    constructor() {
        super();
        this.state = {
            showLogin : true
        }
        
    }
    
    signUpClicked() {
        this.setState({
            showLogin: false
    
          });

    }

    loginClicked() {
        this.setState({
            showLogin: true
    
          });

    }

    render() {


        
        if(this.state.showLogin){

        return (


           
            <div>
                
                <button id="loginButton" onClick={() => this.loginClicked()}> Login</button>
                <button id="signupButton" onClick={() => this.signUpClicked()}>Signup</button>
                <br/><br/>
                <Login/>
                
            </div>
        )
        }
        else
        {
            return (
                <div>
                    
                    <button onClick={() => this.loginClicked()}> Login</button>
                    <button onClick={() => this.signUpClicked()}>Signup</button>
                    <br/><br/>
                    <Signup/>
                    
                </div>
            )
        }
    }
}
