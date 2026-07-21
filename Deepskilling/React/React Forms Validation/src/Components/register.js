import React, { Component } from 'react';

const validateForm = (errors) => {
  let valid = true;
  Object.values(errors).forEach((val) => val.length > 0 && (valid = false));
  return valid;
};

class Register extends Component {
  constructor() {
    super();
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: ''
      }
    };
  }

  handleChange = (event) => {
    event.preventDefault();
    const { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName = value.length < 5 ? 'Full Name must be 5 characters long!' : '';
        break;
      case 'email':
        const validEmailRegex = RegExp(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/);
        errors.email = validEmailRegex.test(value) ? '' : 'Email is not valid!';
        break;
      case 'password':
        errors.password = value.length < 8 ? 'Password must be 8 characters long!' : '';
        break;
      default:
        break;
    }

    this.setState({ errors, [name]: value });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    if (validateForm(this.state.errors) && this.state.fullName && this.state.email && this.state.password) {
      alert('Valid Form');
    } else {
      if (this.state.errors.fullName !== '') {
        alert(this.state.errors.fullName);
      } else if (this.state.errors.email !== '') {
        alert(this.state.errors.email);
      } else if (this.state.errors.password !== '') {
        alert(this.state.errors.password);
      } else {
        alert('Please fill out all fields correctly.');
      }
    }
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2 style={{ color: 'red' }}>Register Here!!!</h2>
        <form onSubmit={this.handleSubmit} noValidate>
          <div style={{ margin: '15px' }}>
            <label style={{ marginRight: '10px', display: 'inline-block', width: '80px', textAlign: 'right' }}>Name:</label>
            <input 
              type="text" 
              name="fullName" 
              value={this.state.fullName} 
              onChange={this.handleChange} 
              noValidate 
            />
          </div>
          <div style={{ margin: '15px' }}>
            <label style={{ marginRight: '10px', display: 'inline-block', width: '80px', textAlign: 'right' }}>Email:</label>
            <input 
              type="email" 
              name="email" 
              value={this.state.email} 
              onChange={this.handleChange} 
              noValidate 
            />
          </div>
          <div style={{ margin: '15px' }}>
            <label style={{ marginRight: '10px', display: 'inline-block', width: '80px', textAlign: 'right' }}>Password:</label>
            <input 
              type="password" 
              name="password" 
              value={this.state.password} 
              onChange={this.handleChange} 
              noValidate 
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Register;
