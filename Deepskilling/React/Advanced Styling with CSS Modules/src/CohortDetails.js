import React from 'react';
import styles from './CohortDetails.module.css';

export default function CohortDetails({ cohort }) {
  const statusStyle = {
    color: cohort.status === "Ongoing" ? "green" : "blue"
  };

  return (
    <div className={styles.box}>
      <h3 style={statusStyle}>Cohort: {cohort.name}</h3>
      <dl>
        <dt>Status</dt>
        <dd>{cohort.status}</dd>
        <dt>Start Date</dt>
        <dd>{cohort.startDate}</dd>
      </dl>
    </div>
  );
}
