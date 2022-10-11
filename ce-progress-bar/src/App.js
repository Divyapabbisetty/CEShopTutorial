import {React,useEffect,useState} from "react";
import './App.css';

export async function getPercent() {

  try{
      const response = await fetch('/api/getPercent');
      return await response.json();
  }catch(error) {
      return [];
  }
  
}

const Progress = () => {
  const [prog, setProg] = useState(0);
  useEffect(() => {
    fetch("http://localhost:8080/api/1/getPercent")
    .then((response) => response.json())
      .then(res => {
        console.log(res);
        setProg(res);
        const newStyle = {
          opacity: 1,
          width: `${prog}%`
        }
        
        setStyle(newStyle);
      })
      .catch(error => console.log(error))});
	const [style, setStyle] = useState({});
	
  
      
	setTimeout(() => {
		const newStyle = {
			opacity: 1,
			width: `${prog}%`
		}
		
		setStyle(newStyle);
	}, 20000);
	
  if(prog != null && prog > 0){
	return (
    
		<div className="progress">
			<div className="progress-done" style={style}>
				{prog}%
			</div>
		</div>
    )
  } else {
    return (
    
      <div className="progress">
        <div className="progress-done" style={style}>
          0%
        </div>
      </div>
      );
  }
}

const App = () => (
	<>
		<h1>React Progress Bar</h1>
		<Progress />
	</>
);

export default App;