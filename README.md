# gerenciar-hospital
O objetivo do projeto é criar uma API para ajudar a organizar um sistema público de saúde.

Questionamentos sobre o projeto:

Produto precisam ser armazenados em uma área de Estoque;
Estoque precisa de uma lista de produtos;
Estoque precisa de um endereço porque ele pode ou não estar em um Hospital; 
	- Quando trato de estoque coloco Banco de Orgãos, Banco de Sangue, Estoque de Remédios, Estoque de Produtos de Limpeza, Estoque de Alimentos. 
	- Isso me fez pensar na possíbilidade de categorizar isso.
Um Hospital precisa de um Endereço, Funcionários, Pacientes e Insumos;
Para ampliar a análise ainda temos a possíbilidade de agrupar por procedimentos médicos:
Um paciente receberá medicamentos nos casos de internação ou mesmo no pós atendimento/consulta.
	- Seria importante criar uma classe com ProcedimentosMedicos com uma lista de insumos para atender aquele procedimento?
	- Isto poderia ajudar no planejamento?
	- Liberação dos insumos precisa de uma autorização?
Considero importante ter o Endereço ou mesmo uma classe Contato reservado em uma classe, pois tanto Hospital, Paciente, Estoque pode utilizar;
	- Evitar erros de digitação uma vez que precisamos ter a localização correta do hospital
Considerando o produto/insumo:
	Ele já deve entrar em um estoque com um destino?
	Caso contrário teríamos que ter um registro de solicitações/pedidos, informando data de saída, o destino do insumo/produto e informação de autorização e solicitação.

