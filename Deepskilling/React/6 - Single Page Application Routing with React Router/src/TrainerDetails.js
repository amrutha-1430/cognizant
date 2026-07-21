import React from 'react';
import { useParams } from 'react-router-dom';
import { TRAINERS } from './trainersmock';

export default function TrainerDetail() {
  const { id } = useParams();
  const trainer = TRAINERS.find(t => t.id === parseInt(id));

  if (!trainer) {
    return <h3>Trainer not found</h3>;
  }

  return (
    <div style={{ border: '1px solid #ccc', padding: '15px', display: 'inline-block', marginTop: '15px' }}>
      <h3>Trainer details for ID: {id}</h3>
      <p><b>Name:</b> {trainer.name}</p>
      <p><b>Technology:</b> {trainer.tech}</p>
      <p><b>School:</b> {trainer.school}</p>
    </div>
  );
}
