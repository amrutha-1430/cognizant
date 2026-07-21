import React from 'react';

function OfficeSpace() {
  const element = "Office Space";
  const ItemName = { Name: "DBS", Rent: 50000, Address: "Chennai" };
  const rentColor = ItemName.Rent <= 60000 ? "red" : "green";

  return (
    <div style={{ textAlign: 'center', marginTop: '30px' }}>
      <h1>{element} , at Affordable Range</h1>
      <div style={{ width: '250px', height: '150px', background: '#ccc', margin: 'auto', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
        Office Space Image
      </div>
      <h1>Name: {ItemName.Name}</h1>
      <h3 style={{ color: rentColor }}>Rent: Rs. {ItemName.Rent}</h3>
      <h3>Address: {ItemName.Address}</h3>
    </div>
  );
}

export default OfficeSpace;
