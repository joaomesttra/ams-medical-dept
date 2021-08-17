package br.com.mesttra.medicaldep.service;

import br.com.mesttra.medicaldep.amqp.AMQPConfig;
import br.com.mesttra.medicaldep.amqp.PlayerMessage;
import br.com.mesttra.medicaldep.entity.Admission;
import br.com.mesttra.medicaldep.repository.AdmissionRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdmissionService {

    AdmissionRepository admissionRepository;
    RabbitTemplate rabbitTemplate;

    public AdmissionService(AdmissionRepository admissionRepository, RabbitTemplate rabbitTemplate) {
        this.admissionRepository = admissionRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Admission registerAdmission(Admission admission) {
        PlayerMessage playerMessage = new PlayerMessage(admission.getPlayerId());
        rabbitTemplate.convertAndSend(AMQPConfig.EXCHANGE_NAME, AMQPConfig.ROUTING_KEY, playerMessage);
        return  admissionRepository.save(admission);
    }
}
