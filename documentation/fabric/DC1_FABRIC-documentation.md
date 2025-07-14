# DC1_FABRIC

## Table of Contents

- [Fabric Switches and Management IP](#fabric-switches-and-management-ip)
  - [Fabric Switches with inband Management IP](#fabric-switches-with-inband-management-ip)
- [Fabric Topology](#fabric-topology)
- [Fabric IP Allocation](#fabric-ip-allocation)
  - [Fabric Point-To-Point Links](#fabric-point-to-point-links)
  - [Point-To-Point Links Node Allocation](#point-to-point-links-node-allocation)
  - [Loopback Interfaces (BGP EVPN Peering)](#loopback-interfaces-bgp-evpn-peering)
  - [Loopback0 Interfaces Node Allocation](#loopback0-interfaces-node-allocation)
  - [VTEP Loopback VXLAN Tunnel Source Interfaces (VTEPs Only)](#vtep-loopback-vxlan-tunnel-source-interfaces-vteps-only)
  - [VTEP Loopback Node allocation](#vtep-loopback-node-allocation)
- [Connected Endpoints](#connected-endpoints)
  - [Connected Endpoint Keys](#connected-endpoint-keys)
  - [Firewalls](#firewalls)
  - [Servers](#servers)
  - [Port Profiles](#port-profiles)

## Fabric Switches and Management IP

| POD | Type | Node | Management IP | Platform | Provisioned in CloudVision | Serial Number |
| --- | ---- | ---- | ------------- | -------- | -------------------------- | ------------- |
| DC1_FABRIC | l2leaf | LEAF1 | 10.10.10.111/24 | vEOS-LAB | Provisioned | - |
| DC1_FABRIC | l2leaf | LEAF2 | 10.10.10.112/24 | vEOS-LAB | Provisioned | - |
| DC1_FABRIC | l2leaf | LEAF3 | 10.10.10.113/24 | vEOS-LAB | Provisioned | - |
| DC1_FABRIC | l2leaf | LEAF4 | 10.10.10.114/24 | vEOS-LAB | Provisioned | - |
| DC1_FABRIC | l2spine | SPINE1 | 10.10.10.101/24 | vEOS-LAB | Provisioned | - |
| DC1_FABRIC | l2spine | SPINE2 | 10.10.10.102/24 | vEOS-LAB | Provisioned | - |

> Provision status is based on Ansible inventory declaration and do not represent real status from CloudVision.

### Fabric Switches with inband Management IP

| POD | Type | Node | Management IP | Inband Interface |
| --- | ---- | ---- | ------------- | ---------------- |

## Fabric Topology

| Type | Node | Node Interface | Peer Type | Peer Node | Peer Interface |
| ---- | ---- | -------------- | --------- | ----------| -------------- |
| l2leaf | LEAF1 | Ethernet1 | l2spine | SPINE1 | Ethernet1 |
| l2leaf | LEAF1 | Ethernet2 | l2spine | SPINE2 | Ethernet1 |
| l2leaf | LEAF1 | Ethernet7 | mlag_peer | LEAF2 | Ethernet7 |
| l2leaf | LEAF1 | Ethernet8 | mlag_peer | LEAF2 | Ethernet8 |
| l2leaf | LEAF2 | Ethernet1 | l2spine | SPINE1 | Ethernet2 |
| l2leaf | LEAF2 | Ethernet2 | l2spine | SPINE2 | Ethernet2 |
| l2leaf | LEAF3 | Ethernet1 | l2spine | SPINE1 | Ethernet3 |
| l2leaf | LEAF3 | Ethernet2 | l2spine | SPINE2 | Ethernet3 |
| l2leaf | LEAF3 | Ethernet7 | mlag_peer | LEAF4 | Ethernet7 |
| l2leaf | LEAF3 | Ethernet8 | mlag_peer | LEAF4 | Ethernet8 |
| l2leaf | LEAF4 | Ethernet1 | l2spine | SPINE1 | Ethernet4 |
| l2leaf | LEAF4 | Ethernet2 | l2spine | SPINE2 | Ethernet4 |
| l2spine | SPINE1 | Ethernet7 | mlag_peer | SPINE2 | Ethernet7 |
| l2spine | SPINE1 | Ethernet8 | mlag_peer | SPINE2 | Ethernet8 |

## Fabric IP Allocation

### Fabric Point-To-Point Links

| Uplink IPv4 Pool | Available Addresses | Assigned addresses | Assigned Address % |
| ---------------- | ------------------- | ------------------ | ------------------ |

### Point-To-Point Links Node Allocation

| Node | Node Interface | Node IP Address | Peer Node | Peer Interface | Peer IP Address |
| ---- | -------------- | --------------- | --------- | -------------- | --------------- |

### Loopback Interfaces (BGP EVPN Peering)

| Loopback Pool | Available Addresses | Assigned addresses | Assigned Address % |
| ------------- | ------------------- | ------------------ | ------------------ |

### Loopback0 Interfaces Node Allocation

| POD | Node | Loopback0 |
| --- | ---- | --------- |

### VTEP Loopback VXLAN Tunnel Source Interfaces (VTEPs Only)

| VTEP Loopback Pool | Available Addresses | Assigned addresses | Assigned Address % |
| ------------------ | ------------------- | ------------------ | ------------------ |

### VTEP Loopback Node allocation

| POD | Node | Loopback1 |
| --- | ---- | --------- |

## Connected Endpoints

### Connected Endpoint Keys

| Key | Type | Description |
| --- | ---- | ----------- |
| firewalls | firewall | - |
| servers | server | - |

### Firewalls

| Name | Port | Fabric Device | Fabric Port | Description | Shutdown | Mode | Access VLAN | Trunk Allowed VLANs | Profile |
| ---- | ---- | ------------- | ------------| ----------- | -------- | ---- | ----------- | ------------------- | ------- |
| FIREWALL | Eth1 | SPINE1 | Ethernet5 | FIREWALL_FIREWALL_Eth1 | False | trunk | - | 10,20,30 | PP-FIREWALL |
| FIREWALL | Eth2 | SPINE2 | Ethernet5 | FIREWALL_FIREWALL_Eth2 | False | trunk | - | 10,20,30 | PP-FIREWALL |

### Servers

| Name | Port | Fabric Device | Fabric Port | Description | Shutdown | Mode | Access VLAN | Trunk Allowed VLANs | Profile |
| ---- | ---- | ------------- | ------------| ----------- | -------- | ---- | ----------- | ------------------- | ------- |
| Host2 | Eth1 | LEAF4 | Ethernet3 | SERVER_Host2_Eth1 | False | access | 30 | - | PP-ORANGE |
| HostA | Eth1 | LEAF1 | Ethernet3 | SERVER_HostA_Eth1 | False | access | 10 | - | PP-BLUE |
| HostB | Eth1 | LEAF2 | Ethernet3 | SERVER_HostB_Eth1 | False | access | 20 | - | PP-GREEN |
| HostC | Eth1 | LEAF3 | Ethernet3 | SERVER_HostC_Eth1 | False | access | 10 | - | PP-BLUE |

### Port Profiles

| Profile Name | Parent Profile |
| ------------ | -------------- |
| PP-BLUE | PP-DEFAULTS |
| PP-DEFAULTS | - |
| PP-FIREWALL | - |
| PP-GREEN | PP-DEFAULTS |
| PP-ORANGE | PP-DEFAULTS |
