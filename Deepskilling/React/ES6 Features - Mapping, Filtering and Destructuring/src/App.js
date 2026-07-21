import React from 'react';
import { OddPlayers, IndianPlayers } from './Players';

function App() {
  const playerNames = ['Jack', 'Michael', 'John', 'Ann', 'Elisabeth'];
  return (
    <div style={{ textAlign: 'center', marginTop: '30px' }}>
      <h2>Odd Players</h2>
      <OddPlayers playerList={playerNames} />
      <h2>Indian Players</h2>
      <ul>
        {IndianPlayers.map((player, idx) => (
          <li key={idx}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;
