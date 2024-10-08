import { useState } from "react"
import { LoginFormComponent } from "./components/LoginFormComponent.jsx"
import { RegisterFormComponent } from "./components/RegisterFormComponent"
import { Link } from "react-router-dom"

export const Session = () => {
    const [typeForm,setTypeForm] = useState("login");

  return (
   <>
      <Link to="/">Regresar</Link>
      <br/>
      <h1>Manejo de sesion</h1>
      <button onClick={() => {setTypeForm('login')}}>Iniciar Sesion</button>
      <button onClick={() => {setTypeForm('signup')}}>Registrarse</button>
      {typeForm === "login" ? <LoginFormComponent/> : <RegisterFormComponent/>}
    
   </>
  )
}