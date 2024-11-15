const form = document.getElementById('procedimentoForm');

form.addEventListener('submit', function(event) {
    event.preventDefault();  // Previne o comportamento padrão de envio do formulári

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
        alert('Ocorreu um erro ao enviar os dados. Tente novamente.');
    });
});
