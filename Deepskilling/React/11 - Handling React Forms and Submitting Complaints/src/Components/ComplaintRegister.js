import React, { Component } from 'react';

class ComplaintRegister extends Component {
  constructor() {
    super();
    this.state = {
      ename: '',
      complaint: '',
      NumberHolder: ''
    };
  }

  handleChange = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    // Generate a random Reference/Transaction number between 1 and 100
    const refNum = Math.floor(Math.random() * 100) + 1;
    this.setState({ NumberHolder: refNum }, () => {
      const msg = 'Thanks ' + this.state.ename + ' \n Your Complaint was Submitted. \n Transaction ID is: ' + this.state.NumberHolder;
      alert(msg);
    });
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2 style={{ color: 'red' }}>Register your complaints here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div style={{ margin: '15px' }}>
            <label style={{ marginRight: '10px', display: 'inline-block', width: '80px', textAlign: 'right' }}>Name:</label>
            <input 
              type="text" 
              name="ename" 
              value={this.state.ename} 
              onChange={this.handleChange} 
              required 
            />
          </div>
          <div style={{ margin: '15px' }}>
            <label style={{ marginRight: '10px', display: 'inline-block', width: '80px', textAlign: 'right', verticalAlign: 'top' }}>Complaint:</label>
            <textarea 
              name="complaint" 
              value={this.state.complaint} 
              onChange={this.handleChange} 
              required 
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
