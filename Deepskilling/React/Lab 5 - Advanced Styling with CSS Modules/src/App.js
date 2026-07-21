import CohortDetails from './CohortDetails';

function App() {
  const cohort1 = { name: "Java FSE Cohort 1", status: "Ongoing", startDate: "2026-06-01" };
  const cohort2 = { name: "React Cohort 2", status: "Completed", startDate: "2026-05-15" };

  return (
    <div style={{ padding: '20px', textAlign: 'center' }}>
      <h1>Academy Cohorts</h1>
      <CohortDetails cohort={cohort1} />
      <CohortDetails cohort={cohort2} />
    </div>
  );
}

export default App;
