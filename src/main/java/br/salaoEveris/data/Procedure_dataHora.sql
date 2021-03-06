USE [Salaoeveris]
GO
/****** Object:  StoredProcedure [dbo].[SP_BuscarAgendamentos]    Script Date: 11/11/2020 09:23:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER procedure [dbo].[SP_BuscarAgendamentos]
	@dataInicio datetime2, @dataFim datetime2

AS
BEGIN
SELECT 
	Cliente.nome clienteNome,
	Agendamento.dataHora,
	Servico.valor,
	Servico.nome nomeServico,
	Agendamento.id
FROM Agendamento 
	INNER JOIN Cliente ON Agendamento.clienteId  = Cliente.id
	INNER JOIN Servico ON Agendamento.servicoId  = Servico.id
WHERE dataHora BETWEEN  @dataInicio AND @dataFim
END