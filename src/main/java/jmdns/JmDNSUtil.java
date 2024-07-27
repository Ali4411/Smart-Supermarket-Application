package jmdns;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class JmDNSUtil {
    private JmDNS jmdns;

    public JmDNSUtil() throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        jmdns = JmDNS.create(localHost);
    }

    public void registerService(String serviceName, int port) throws IOException {
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", serviceName, port, "gRPC service");
        jmdns.registerService(serviceInfo);
    }

    public void close() throws IOException { 
        if (jmdns != null) {
            jmdns.close();
        }
    }
}
