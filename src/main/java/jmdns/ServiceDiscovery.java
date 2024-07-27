package jmdns;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class ServiceDiscovery {
    private JmDNS jmdns;
    private List<ServiceInfo> services = new ArrayList<>();

    public ServiceDiscovery() throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        jmdns = JmDNS.create(localHost);
    }

    public void discoverServices() {
        jmdns.addServiceListener("_grpc._tcp.local.", new ServiceListener() {
            @Override
            public void serviceAdded(ServiceEvent event) {
                System.out.println("Service added: " + event.getInfo().getName());
                jmdns.requestServiceInfo(event.getType(), event.getName(), true);
            }

            @Override
            public void serviceRemoved(ServiceEvent event) {
                System.out.println("Service removed: " + event.getInfo().getName());
                services.removeIf(info -> info.getName().equals(event.getName()));
            }

            @Override
            public void serviceResolved(ServiceEvent event) {
                System.out.println("Service resolved: " + event.getInfo().getName());
                services.add(event.getInfo());
            }
        });
    }

    public List<ServiceInfo> getServices() {
        return services;
    }

    public ServiceInfo getServiceByName(String serviceName) {
        for (ServiceInfo serviceInfo : services) {
            if (serviceInfo.getName().equals(serviceName)) {
                return serviceInfo;
            }
        }
        return null;
    }
}

