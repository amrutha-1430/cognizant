import React from 'react';
import { Link } from 'react-router-dom';
import { TRAINERS } from './trainersmock';

export default function TrainersList() {
  return (
    <div>
      <h2>Trainers List</h2>
      <ul>
        {TRAINERS.map(t => (
          <li key={t.id}>
            <Link to={`/trainer/${t.id}`}>{t.name} - {t.tech}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
}
