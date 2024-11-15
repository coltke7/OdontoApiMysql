const form = document.getElementById('telacad_pacienteForm');

form.addEventListener('submit', function(event) {
    event.preventDefault();

    // Coleta os dados do formulário
// Coleta os dados do formulário
const paciente = {
    nome: document.getElementById('nome').value,
    rg: document.getElementById('rg').value,
    cpf: document.getElementById('cpf').value,
    data_nascimento: document.getElementById('data_nascimento').value,
    idade: document.getElementById('idade').value,
    endereco: document.getElementById('endereco').value,
    numero: document.getElementById('numero').value,
    genero: document.getElementById('genero').value,
    hipertensao: document.getElementById('hipertensao').value,
    gravidez: document.getElementById('gravidez').value,
    avc: document.getElementById('avc').value,
    medicacao: document.getElementById('medicacao').value.split(','),  // Aqui, dividir a string por vírgula para criar um array
    alergia: document.getElementById('alergia').value.split(','),     // O mesmo para alergias
    cirurgia: document.getElementById('cirurgia').value.split(',')    // E para cirurgias, caso necessário
};


    console.log('Dados do Paciente:', paciente);

    // Envia os dados para o servidor utilizando fetch POST
    fetch('http://localhost:8080/paciente/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(paciente)  // Envia os dados como JSON
    })
    .then(response => response.json())  // Converte a resposta em JSON
    .then(data => {
        console.log('Dados enviados com sucesso:', data);
        alert('Cadastro realizado com sucesso!');
    })
    .catch(error => {
        console.error('Erro ao enviar os dados:', error);
        alert('Ocorreu um erro ao enviar os dados. Tente novamente.');
    });
});
