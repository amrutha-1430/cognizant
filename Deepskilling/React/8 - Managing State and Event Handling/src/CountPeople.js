import React, { Component } from 'react';

class CountPeople extends Component {
  constructor() {
    super();
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <button style={{ backgroundColor: 'lightgreen' }} onClick={this.updateEntry}>Login</button>
        <span style={{ margin: '0 20px' }}>{this.state.entrycount} People Entered!!!</span>
        <button style={{ backgroundColor: 'lightgreen' }} onClick={this.updateExit}>Exit</button>
        <span style={{ marginLeft: '10px' }}>{this.state.exitcount} People Left!!!</span>
      </div>
    );
  }
}

export default CountPeople;
