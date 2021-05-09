import NavBar from "components/NavBar";
import { Link } from "react-router-dom";

const Home = () => {
    return (
        <>
            <NavBar />
            <div className="container">
                <div className="jumbotron">
                    <h1 className="display-5">DSVendas</h1>
                    <p className="lead"> Analise o desempenho das suas vendas por diferentes érséctovas</p>
                    <hr />
                    <p>Está aplicação consiste em exibir um dashboard a partir de dados fornecidos por um backend construído com Spring Boot</p>
                    <Link className="btn btn-primary btn-lg" to="/dashboard">
                    </Link>
                </div>
            </div>
            <footer />
        </>
    );
}

export default Home;
