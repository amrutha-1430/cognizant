import React from 'react';
import CohortDetails from './Components/CohortDetails';
import { CohortData } from './Cohort';

function App() {
  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h1>Cohort Tracker Dashboard</h1>
      <CohortDetails cohort={CohortData[0]} />
    </div>
  );
}

export default App;
