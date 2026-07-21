import React, { useEffect, useState } from 'react';
import './App.css';
import GitClient from './GitClient';

function App() {
  const [repositories, setRepositories] = useState([]);

  useEffect(() => {
    GitClient.getRepositories('techiesyed')
      .then(r => setRepositories(r.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div className="App" style={{ textAlign: 'center', marginTop: '30px' }}>
      <h1>Git repositories of User - TechieSyed</h1>
      <div style={{ margin: '0 auto', maxWidth: '400px', textAlign: 'left' }}>
        {repositories.map(r => (
          <p key={r.name}>{r.name}</p>
        ))}
      </div>
    </div>
  );
}

export default App;
