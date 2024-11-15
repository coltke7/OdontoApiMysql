// Função para buscar o paciente com base no CPF
function buscarPaciente(event) {
    event.preventDefault();  // Previne o envio do formulário

    // Pega o CPF inserido pelo usuário
    const cpf = document.getElementById('cpf').value.trim();

    if (!cpf) {
        alert('Por favor, insira um CPF válido.');
        return;
    }

    // Formata a URL para a requisição GET
    const url = `http://localhost:8080/historico/cpf/${cpf}`;

    // Realiza a requisição GET para a URL com o CPF
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Paciente não encontrado');
            }
            return response.json();  // Converte a resposta para JSON
        })
        .then(data => {
            // Exibe os dados do paciente
            exibirPaciente(data);
        })
        .catch(error => {
            console.error('Erro ao buscar os dados do paciente:', error);
            alert('Não foi possível encontrar o paciente. Verifique o CPF e tente novamente.');
        });
}

// Função para exibir os dados do paciente na tela
function exibirPaciente(data) {
    // Checa se o paciente foi encontrado
    if (!data || !data.paciente) {
        alert('Paciente não encontrado.');
        return;
    }

    const paciente = data.paciente;
    const pacienteInfoDiv = document.getElementById('pacienteInfo');
    const dadosPacienteDiv = document.getElementById('dadosPaciente');

    // Monta os dados do paciente para exibir
    const pacienteInfo = `
        <p><strong>Nome:</strong> ${paciente.nome}</p>
        <p><strong>RG:</strong> ${paciente.rg}</p>
        <p><strong>CPF:</strong> ${paciente.cpf}</p>
        <p><strong>Data de Nascimento:</strong> ${new Date(paciente.data_nascimento).toLocaleDateString()}</p>
        <p><strong>Idade:</strong> ${paciente.idade} anos</p>
        <p><strong>Endereço:</strong> ${paciente.endereco}</p>
        <p><strong>Telefone:</strong> ${paciente.numero}</p>
        <p><strong>Gênero:</strong> ${paciente.genero === 'M' ? 'Masculino' : paciente.genero === 'F' ? 'Feminino' : 'Outro'}</p>
        <p><strong>Medicamentos:</strong> ${paciente.medicacao.join(', ')}</p>
        <p><strong>Hipertensão:</strong> ${paciente.hipertensao === 'S' ? 'Sim' : 'Não'}</p>
        <p><strong>Gravidez:</strong> ${paciente.gravidez === 'S' ? 'Sim' : 'Não'}</p>
        <p><strong>AVC:</strong> ${paciente.avc === 'S' ? 'Sim' : 'Não'}</p>
        <p><strong>Alergias:</strong> ${paciente.alergia.join(', ')}</p>
        <p><strong>Cirurgias:</strong> ${paciente.cirurgia.join(', ')}</p>
        <p><strong>Procedimentos Realizados:</strong> ${data.procimentosRealizados.join(', ')}</p>
    `;

    // Exibe as informações do paciente
    dadosPacienteDiv.innerHTML = pacienteInfo;
    pacienteInfoDiv.style.display = 'block';  // Mostra os dados
}
