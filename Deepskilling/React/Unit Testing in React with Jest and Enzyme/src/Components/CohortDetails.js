import React from 'react';

export default function CohortDetails({ cohort }) {
  if (!cohort) return null;
  return (
    <div className="box">
      <h3>{cohort.name}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>
      </dl>
    </div>
  );
}
