function maskcpf(input) {
  let text = input.value.replace(/\D/g, ''); // Remove non-numeric characters
  if (text.length > 11) {
    text = text.substring(0, 11); // Truncate to 11 digits
  }
  if (text.length > 9) {
    text = text.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
  } else if (text.length > 6) {
    text = text.replace(/(\d{3})(\d{3})(\d{3})/, '$1.$2.$3');
  } else if (text.length > 3) {
    text = text.replace(/(\d{3})(\d{3})/, '$1.$2');
  }
  input.value = text;
}
var idhistorico;
document.getElementById('cpf').addEventListener('blur', function() {
    const cpf = document.getElementById('cpf').value;  // Obtem o CPF informado no campo
    if (!cpf) {
        alert('Por favor, informe o CPF do paciente.');
        return;
    }

    // Faz a consulta do paciente pelo CPF
	fetch(`http://localhost:8080/historico/cpf/${cpf}`) 
        .then(response => {
            if (!response.ok) {
                throw new Error('Paciente não encontrado');
            }
            return response.json();  // Convertendo a resposta para JSON
        })
        .then(data => {
            // Se o paciente for encontrado, exibimos as informações
            const pacienteNome = data.paciente.nome;
            // Atualizando os campos na interface
			idhistorico = data.id;
            document.getElementById('pacienteNomeDisplay').textContent = pacienteNome;
            // Exibindo o bloco com as informações do paciente
            document.getElementById('pacienteInfo').style.display = 'block';
            // Armazenamos o ID do paciente no campo oculto para enviar depois
        })

});


const form = document.getElementById('procedimentoForm');

form.addEventListener('submit', function(event) {
    event.preventDefault(); 
var procedimento = document.getElementById('procedimentos').value; // Previne o comportamento padrão de envio do formulário
	    const procedimentos = {
			              historico: {
	                         id: idhistorico
						  },
	                      procedimentos : procedimento
	                    };
	    // Enviar os dados para o servidor usando o método POST
		fetch('http://localhost:8080/procedimentos/', {
		        method: 'POST',
		        headers: {
		            'Content-Type': 'application/json'  // Definir o tipo de conteúdo como JSON
		        },
		        body: JSON.stringify(procedimentos)  // Converter o objeto para JSON antes de enviar
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