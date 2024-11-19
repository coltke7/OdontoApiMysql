document.getElementById('consultarPaciente').addEventListener('click', function() {
    const cpf = document.getElementById('cpf').value;  // Obtem o CPF informado no campo
    if (!cpf) {
        alert('Por favor, informe o CPF do paciente.');
        return;
    }

    // Faz a consulta do paciente pelo CPF
	fetch(`http://localhost:8080/paciente/cpf/${cpf}`) 
        .then(response => {
            if (!response.ok) {
                throw new Error('Paciente não encontrado');
            }
            return response.json();  // Convertendo a resposta para JSON
        })
        .then(data => {
            // Se o paciente for encontrado, exibimos as informações
            const pacienteId = data.id;
            const pacienteNome = data.nome;
            const pacienteIdade = data.idade;
            const pacienteEndereco = data.endereco;

            // Atualizando os campos na interface
            document.getElementById('pacienteIdDisplay').textContent = pacienteId;
            document.getElementById('pacienteNomeDisplay').textContent = pacienteNome;

            // Se desejar exibir mais informações do paciente, pode adicionar aqui:
            // Exemplo: idade e endereço
            console.log('Idade:', pacienteIdade);
            console.log('Endereço:', pacienteEndereco);

            // Exibindo o bloco com as informações do paciente
            document.getElementById('pacienteInfo').style.display = 'block';

            // Armazenamos o ID do paciente no campo oculto para enviar depois
            document.getElementById('pacienteId').value = pacienteId;
        })
        .catch(error => {
            console.error('Erro ao consultar o paciente:', error);
        });
});

const form = document.getElementById('procedimentoForm');

form.addEventListener('submit', function(event) {
    event.preventDefault();  // Previne o comportamento padrão de envio do formulário


	   // Obtendo o valor do ID do paciente e os procedimentos realizados
	    const pacienteId = Number(document.getElementById('pacienteId').value);  // Converte para número inteiro
	    const procedimentos = document.getElementById('procedimentos').value.split(',').map(p => p.trim());  // Remove espaços extras

	    // Verifique no console se os dados estão sendo preenchidos corretamente


	    // Criar o objeto de dados para enviar ao backend
	    const historico = {
	                      "paciente": {
	                        "id":pacienteId
	                      },
	                      "procimentosRealizados": procedimentos
	                    };

	    // Verifique no console o JSON criado para garantir que está correto
	    console.log('Dados para envio:', JSON.stringify(historico));  // Verifique o JSON

	    // Enviar os dados para o servidor usando o método POST
		fetch('http://localhost:8080/historico/', {
		        method: 'POST',
		        headers: {
		            'Content-Type': 'application/json'  // Definir o tipo de conteúdo como JSON
		        },
		        body: JSON.stringify(historico)  // Converter o objeto para JSON antes de enviar
		    })
			
	    .then(response => response.json())  // A resposta deve ser convertida para JSON
	    .then(data => {
	        console.log('Resposta do servidor:', data);
	        alert('Cadastro realizado com sucesso!');
	    })
	    .catch(error => {
	        console.error('Erro ao enviar os dados:', error);
	    });
	});